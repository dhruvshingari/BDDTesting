pipeline{
    agent any
    
    stages{
        
        stage('Checkout'){
            steps{
                checkout([
                    $class:'GitSCM',
                    branches:[[name: '*/main']],
                    userRemoteConfigs:[[
                            url:'https://github.com/dhruvshingari/BDDTesting.git'
                        ]]
                    
                    ]
                )
            }
        }
        
         stage('code Build'){
            steps{ 
                bat "mvn clean compile"
                 }
        }
        
         stage('Test'){
            steps{
                bat "mvn test"
                 }
         }
         
         stage('Package'){
             steps{
                     bat "mvn package"
                  }
         }

        stage('Deployment'){
            steps{
                    bat "java -jar target/BDDTesting-0.0.1-SNAPSHOT.jar"
            }
    }
    }
    post {
        always {
            cleanWs(cleanWhenNotBuilt: false,
                    deleteDirs: true,
                    disableDeferredWipeout: true,
                    notFailBuild: true,
                    patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
                               [pattern: '.propsfile', type: 'EXCLUDE']])
        }
        
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed. Please check logs.'
        }
    }
}
    