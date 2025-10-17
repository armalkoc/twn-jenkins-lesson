pipeline {
    agent any

    tools {
        maven 'maven-3.9'
    }

    stages {
        stage("Increment App Version") {
            steps {
                script {
                    echo "Incrementing Application Version ..."
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
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
                script {
                    echo "Building the Docker Image ..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-private-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                        sh "docker build -t amalkoc/twn-demo-app:${IMAGE_NAME} ."
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh "docker push amalkoc/twn-demo-app:${IMAGE_NAME}"
                    }
                }
            }
        }
        stage("Commit pom.xml Version Update") {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'github-webhook-acc', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                        sh 'git config --global user.email "armin.bootcamp@gmail.com"'
                        sh 'git config --global user.name "amalkoc"'

                        sh 'git status'
                        sh 'git branch'
                        sh 'git config --list'

                        sh "git remote set-url origin https://${USER}:${PASS}@github.com/armalkoc/twn-jenkins-lesson.git"
                        sh 'git add .'
                        sh 'git commit -m "ci: version bump"'
                        sh 'git push origin HEAD:jenkins-jobs'
                    }
                }
            }
        }
    }
}