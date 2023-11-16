pipeline {
    agent { 
        node {
            label 'nas01'
            }
      }
    stages {
        stage('Build') {
            steps {
                sh "echo $JAVA_HOME"
                sh "./gradlew build"
                sh "docker build -t bigdata ."
            }
        }
        stage('Deploy') {
            steps {
                sh "docker run --network='host' -p 8000:8000 bigdata"
            }
        }
    }
}
