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

                    sh("kubectl run devops-instance --image eu.gcr.io/lyrical-brook-181709/devopsexam:${env.BUILD_NUMBER} --port 8080")
                    sh("kubectl expose deployment devops-instance --type='LoadBalancer'")
                    sh("kubectl scale --replicas=3 deployment/devops-instance")



                    //sh('gcloud container clusters get-credentials devops-kubernetes-cluster --zone ${DEV_OPS_ZONE} --project ${DEV_OPS_PROJECT_ID}')
                    //sh('kubectl set image deployment/springserver springserver=eu.gcr.io/${DEV_OPS_PROJECT_ID}/springserver:${BUILD_NUMBER}')
                    //sh('gcloud container clusters resize devops-kubernetes-cluster --size 1 --quiet')
                    //sh('gcloud container clusters resize devops-kubernetes-cluster --size 3 --quiet')

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