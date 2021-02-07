job("nodejs app deploy") {
    scm {
        git('https://github.com/jinwoov/BlogPost-Node.git) { node -> 
        node / gitConfig("jinwoov")
        node / gitconfig("jinwoov@gmail.com")
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