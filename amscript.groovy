def buildJar() {
    echo "In this step jar file is being built ..."
    sh 'mvn package'
}

def buildImage(String appVersion) {
    echo "in this step Docker Image is being built"
    withCredentials([usernamePassword(credentialsId: 'docker-full-pip', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t 192.168.0.112:3031/full-pipeline-lesson:am-${version} .'
        sh 'echo $PASS | docker login -u ${USER} --password-stdin 192.168.0.112:3031'
        sh 'docker push 192.168.0.112:3031/full-pipeline-lesson:am-1.0'
    }
}

def deployApp() {
    echo "Deploying Docker Image application ..."
}

return this