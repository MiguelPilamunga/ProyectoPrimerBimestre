pipeline {
    agent any

	  tools
    {
       maven "Maven"
    }
 stages {
      stage('checkout') {
           steps {

                git branch: 'master', url: 'https://github.com/MiguelPilamunga/ProyectoPrimerBimestre.git'

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
}