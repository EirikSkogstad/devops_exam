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
                    sh("docker build -t skogeir15/devopsexam:latest .")

                }
            }
        }

        stage('Tag and deploy image to Google cloud') {
            steps {
                dir('devopsexam') {
                    sh('gcloud auth activate-service-account --key-file ~/gcloud/service_key')
                    sh('gcloud config set project lyrical-brook-181709')
                    sh('gcloud config set compute/zone europe-west1-c')

                    sh("docker tag skogeir15/devopsexam:latest eu.gcr.io/lyrical-brook-181709/devopsexam:latest ")
                    sh("gcloud docker -- push eu.gcr.io/lyrical-brook-181709/skogeir15/devopsexam:latest")

                    sh('gcloud container clusters create devops-kubernetes-cluster')
                    //sh('gcloud docker -- push eu.gcr.io/${DEV_OPS_PROJECT_ID}/springserver:${BUILD_NUMBER}')
//                    sh('gcloud config set compute/zone ${DEV_OPS_ZONE}')
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