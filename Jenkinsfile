pipeline {
    agent any
    stages {
        stage('Compile BackEnd') {
            steps {
                withMaven(maven: 'maven-3.6.3'){
                    sh 'mvn clean compile'
                }

            }
        }
        stage('Test BackEnd'){
             steps {
                withMaven(maven: 'maven-3.6.3'){
                    sh 'mvn test'
                }

            }
        }
    }
}