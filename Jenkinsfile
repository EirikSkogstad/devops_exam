pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven'
    }

    stages {
        stage('Run tests') {
            steps {
                sh('mvn test')
            }
        }
    }
}