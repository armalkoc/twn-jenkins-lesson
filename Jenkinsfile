pipeline {
    agent any

    stages {
        stage("Increment App Version") {
            steps {
                script {
                    echo "Incrementing Application Version ..."
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    def mathcer = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }

        stage("Build Application") {
            steps {
                script {
                    echo "Building the Application ..."
                    sh 'mvn clean package'
                }
            }
        }
        stage("Build Image") {
            steps {
                scrtip {
                    echo "Building the Docker Image ..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-private-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                        sh "docker build -t amalkoc/twn-demo-app:${IMAGE_NAME} ."
                        sh 'echo $PASS | docker login -u $USER --password-stin'
                        sh "docker push amalkoc/twn-demo-app:${IMAGE_NAME}"
                    }
                }
            }
        }
    }
}