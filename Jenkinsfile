pipeline {
    agent { 
        node {
            label 'nas01'
            }
      }
    stages {
        stage('Build') {
            steps {
                sh '''
                ./gradlew build
                '''
            }
        }
        stage('Test') {
            steps {
                sh '''
                echo test...
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh "java -jar ./build/libs/bigdata-0.0.1-SNAPSHOT.jar"
            }
        }
    }
}
