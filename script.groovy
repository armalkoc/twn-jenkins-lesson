def buildApp() {
    echo "Building the application ..."
}

def testApp() {
     echo "Testing application  ${params.selectedVersion} ..."
}

def deployApp() {
    echo "Deploying Application ..."
}
return this