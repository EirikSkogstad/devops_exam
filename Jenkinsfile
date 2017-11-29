pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven'
    }

    stages {
//        stage('Run tests') {
//            steps {
//                dir('devopsexam') {
//                    sh('mvn test')
//                }
//            }
//        }

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
                    sh('gcloud config set project devopsexam')
                    sh('gcloud config set compute/zone europe-west1-c')

                    sh("gcloud docker -- push eu.gcr.io/lyrical-brook-181709/devopsexam:${env.BUILD_NUMBER}")
                    sh('gcloud container clusters create devops-kubernetes-cluster')

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