@Library('am-jenkins-shared-library')
def gv
pipeline {
    
    agent any

    tools {
        maven 'maven-3.9'
    }
    
    stages {
        stage("initialize") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    buildJar()
                }
            }
            }
        stage("build and push image") {
            steps {
                script {
                    buildImage 'amalkoc/twn-demo-app:jma-3.0'
                    dockerLogin()
                    dockerPush 'amalkoc/twn-demo-app:jma-3.0'
                }
            }
        }
        stage("app deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
 
        }
    }
    
}