job("nodejs app deploy") {
    scm {
        git('git://github.com/jinwoov/BlogPost-Node.git') { node -> 
        node / gitConfig("jinwoov")
        node / gitconfig("jinwoov@gmail.com")
        }
    }
    trigger {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
}