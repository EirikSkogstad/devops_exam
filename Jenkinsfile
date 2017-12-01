pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven'
    }

    stages {
        stage('clean and build') {
            steps{
                dir('devopsexam') {
                    sh('mvn clean install')
                }
            }
        }

        stage('Build docker image') {
            steps {
                dir('devopsexam') {
                    sh('whoami')
                    echo "${env.BUILD_NUMBER}"
                    sh("docker build -t eu.gcr.io/lyrical-brook-181709/devopsexam:${env.BUILD_NUMBER} . ")

                }
            }
        }


        stage('Deploy image to Google cloud') {
            steps {
                dir('devopsexam') {
                    sh('gcloud auth activate-service-account --key-file ~/gcloud/service_key')
                    sh('gcloud config set project lyrical-brook-181709')
                    sh('gcloud config set compute/zone europe-west3-a')

                    sh("gcloud docker -- push eu.gcr.io/lyrical-brook-181709/devopsexam:${env.BUILD_NUMBER}")
                    sh('gcloud container clusters get-credentials devops-kubernetes-cluster --zone europe-west3-a --project lyrical-brook-181709')

                    sh("kubectl run devops-kubernetes-cluster --image eu.gcr.io/lyrical-brook-181709/devopsexam:75 --port=80")
                    //sh("kubectl set image deployment/devopsexam  devopsexam=eu.gcr.io/lyrical-brook-181709/devopsexam:${env.BUILD_NUMBER}")
                    sh("kubectl scale --replicas=1 deployment/devopsexam")
                    sh("kubectl scale --replicas=4 deployment/devopsexam")
                }
            }
        }

        stage('Clean up after yourself') {
            steps{
                dir('devopsexam') {
                    sh('mvn clean')
                }
            }
        }
    }
}