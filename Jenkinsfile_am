def gv
pipeline {
    agent any
    tools {
        maven "maven-3.9"
    }

    parameters {
        string(name: 'AppVersion', defaultValue: '', description: 'Specify application version')
        choice(name: 'selectedVersion', choices: ['1.1.0', '1.2.0', '1.3.0', '1.4.0', '1.5.0'], description: 'these are available versions')
        booleanParam(name: 'executeTest', defaultValue: '', description: 'Test should be executed or not ?')
    }

    stages {
        stage("initialzie") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }

        stage("Test") {
            steps {
                script {
                    gv.testApp()
                }

            }

        }

        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}