pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven'
    }

    stages {
        steps{
            stage('Run tests') {
                sh('mvn test')
            }
        }
    }
}