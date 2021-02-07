job("nodejs-docker") {
    scm {
        git('https://github.com/jinwoov/BlogPost-Node.git') { node -> 
            node / gitConfigName("jinwoov")
            node / gitConfigEmail("jinwoov@gmail.com")
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish { // name
            repositoryName('jinwoov/nodejs-tester') // repository name
            tag('${GIT_REVISION,length=9}') //tagging it unique SHA tagging it to the latest github commit
            registryCredentials('dockerhub') // 
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}