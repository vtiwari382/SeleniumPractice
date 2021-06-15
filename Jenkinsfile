pipeline { 
agent any 
    stages {        
        stage ('Build') { 
            steps{
                echo "Building"
            }
        }
        
        stage('Deploy to QA') {
            steps {
				echo "Deploy to QA" 
            }
        }
                    
        stage('Test On QA') {
           steps {
                echo "Regression Test on QA"
            }
        }
        
        
        stage('Deploy To Stage') {
           steps {
                echo "Deploy to Stage"
            }
        }
		
		stage('Test On Stage') {
           steps {
                echo "Sanity Test on Stage"
            }
        }
        
		stage('Deploy On Production') {
           steps {
                echo "Deploy to Production"
            }
        }
		
		stage('Monitor') {
           steps {
                echo "Monitor the Prod logs"
            }
        }                
    }
 }