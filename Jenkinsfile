pipeline {
    agent any

    tools {
        jdk 'jdk17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/sasi19S/als-demo-artifact.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh '''
                  chmod +x mvnw
                  ./mvnw clean test package
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                  docker build -t als-demo-artifact:latest .
                '''
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed'
            deleteDir()
        }
    }
}
