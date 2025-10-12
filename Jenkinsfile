pipeline {
    
    agent any
    
    stages {
        stage("app test") {
            steps {
                script {
                    echo "Testing Application"
                    echo "Executing the Pipeline for branch ${BRANCH_NAME}"
                }
            }
        }
        stage("app build") {
            when {
                expression {
                    BRANCH_NAME = 'master'
                }
            }
            steps {
                script {
                    echo "Building the application just for branch ${BRANCH_NAME}"
                }
            }
            }
        stage("app deploy") {
            when {
                expression {
                    BRANCH_NAME = 'master'
                }
            }
            steps {
                script {
                    echo "deploying the application for the branch ${BRANCH_NAME}"
                }
            }
 
        }
    }
    
}