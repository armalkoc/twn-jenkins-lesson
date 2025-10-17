def grv 
pipeline {
    
    agent any
    tools {
        maven 'maven-3.9'
    }

    parameters {
        string(name:'appVersion', defaultValue:'', description:'define app version')
        choice(name:'availableVersions', choices: ['1.1', '1.2', '1.3', '1.4', '1.5'], description: 'these are available app versions')
        booleanParam(name:'executeTest', defaultValue: '', description: 'define if test is needed or not')
    }

    stages {
        stage("initialize groovy script") {
            steps {
                script {
                    grv = load "amscript.groovy"
                }
            }
        }

        stage("build Jar artifact") {
            steps {
                script {
                    grv.buildJar()
                }
            }
        }
        stage("build docker image") {
            steps {
                script {
                    grv.buildImage(params.availableVersions)
                    }
                }
            }
        stage("deploy Docker Image") {
            steps {
                script {
                    grv.deployApp(params.availableVersions)
                    }
                }
        }
    }
}
