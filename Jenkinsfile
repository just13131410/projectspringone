pipeline{
    agent any
    
    environment {
        //once you sign up for Docker hub, use that user_id here
        registry = "just13131410/boot-spring-ui"
        //- update your credentials ID after creating credentials for connecting to Docker Hub
        registryCredential = 'dockerhub_id'
        dockerfile = 'just13131410/boot-spring-ui'
    }
    
    stages{
        
        stage('scm Backend'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/just13131410/projectspringone.git']]])
            }
        }
         stage('scm Frontend'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: './ui']], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/just13131410/DevOpsDemoFrontEnd.git']]])
            }
        }
        stage ('Build Backend jar') {
            steps {
                sh 'mvn -Dtests.skip=true package -P test install' 
            }
        }
        
        stage ('Build Frontend image and Pushing to Docker') {
            steps {
                echo "workspace directory is ${workspace}"
                dir ("$workspace\\ui"){
                   sh 'docker build -t just13131410/boot-spring-ui  .'
                }
                  
                //here Push
                script {
                    docker.withRegistry( '', registryCredential ) {
            
                        def customImage = docker.build(registry + ":${env.BUILD_ID}")

                        //here OK
                        customImage.push()
                        
                        //Push OK
                    }
                }
            }
        }
        
        stage('Starting whole App docker compose') {
            parallel {
                stage('docker-compose up') {
                    steps {
                        sh 'docker-compose up -d'
                    }
                }
                stage('test') {
                  steps {
                    sh 'sleep 30'
                    
                    sh 'mvn -Dtest=SeleniumTestNG test'
                    
                    sh 'sleep 10'
                    
                    sh 'docker-compose down --remove-orphans'
                  }
                }
        
            }
        }
        
         
    }
    post { 
        always {
          sh 'docker-compose down --remove-orphans'
        }
    }
}