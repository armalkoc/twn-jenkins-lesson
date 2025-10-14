//def buildJar() {
//    echo 'building the application...'
//    sh 'mvn package'
//}

//def buildImage() {
//    echo "building the docker image..."
//   withCredentials([usernamePassword(credentialsId: 'docker-hub-private-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//        sh 'docker build -t amalkoc/twn-demo-app:am-sl-1.0 .'
//        sh 'echo $PASS | docker login -u $USER --password-stdin'
//        sh 'docker push amalkoc/twn-demo-app:am-sl-1.0'
//    }
//}

def deployApp() {
    echo 'deploying the application...'
}

return this