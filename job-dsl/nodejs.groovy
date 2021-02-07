job("nodejs app deploy") {
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
        shell("npm install")
    }
}