pipeline {
    agent any

    environment {
        // Docker image name
        DOCKER_IMAGE = "als-demo-artifact:latest"
    }

    tools {
        // Maven tool name configured in Jenkins → Global Tool Configuration
        maven 'Maven-3.9.0' 
        // Git is auto-detected
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Pulling code from GitHub..."
                git branch: 'main',
                    url: 'https://github.com/sasi19S/als-demo-artifact.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo "Running tests and building JAR..."
                sh './mvnw clean test package -DskipTests=false'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image..."
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Push Docker Image (Optional)') {
            steps {
                echo "You can push image to DockerHub or ECR here if configured"
                // Example: docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') { sh "docker push ${DOCKER_IMAGE}" }
            }
        }
    }

    post {
        always {
            echo "Cleaning up workspace..."
            cleanWs()
        }
        success {
            echo "Pipeline completed successfully!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
