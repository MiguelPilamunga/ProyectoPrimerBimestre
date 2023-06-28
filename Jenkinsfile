pipeline {
    agent any

	  tools
    {
       maven "Maven"
    }
 stages {
      stage('checkout') {
           steps {

                git branch: 'master', url: 'https://github.com/devops4solutions/CI-CD-using-Docker.git'

          }
        }
	 stage('Execute Maven') {
           steps {

                sh 'mvn clean compile  package'
          }
        }


  stage('Docker Build and Tag') {
           steps {

                sh 'docker build -t testDocker:latest .'


          }
        }

	}