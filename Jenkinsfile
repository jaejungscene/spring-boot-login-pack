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
                echo $JAVA_HOME
                ./gradlew build
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
