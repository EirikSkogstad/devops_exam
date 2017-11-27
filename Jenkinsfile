pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven'
    }

    stages {
        stage('Run tests') {
            steps {
                dir('devopsexam') {
                    sh('mvn test')
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