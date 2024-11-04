#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker_hub_repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t retr0009/demo-app:jma-2.0 .'
        sh '''
        echo $PASS | docker login -u $USER --password-stdin
        '''
        sh 'docker push retr0009/demo-app:jma-2.0'
    }
}