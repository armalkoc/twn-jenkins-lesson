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
                    env.BRANCH_NAME == "master"
                }
            }
            steps {
                script {
                    echo "Building the application"
                }
            }
            }
        stage("app deploy") {
            when {
                expression {
                    env.BRANCH_NAME == "master"
                }
            }
            steps {
                script {
                    echo "deploying the application"
                }
            }
 
        }
    }
    
}