pipeline {
    
    agent any
    
    stages {
        stage("app test") {
            steps {
                script {
                    echo "Testing Application"
                    echo "Executing the Pipeline"
                }
            }
        }
        stage("app build") {
            when {
                expression {
                    BRANCH_NAME = "master"
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
                    BRANCH_NAME = "master"
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