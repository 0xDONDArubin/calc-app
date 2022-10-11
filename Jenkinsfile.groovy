pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat "build.cmd"
            }
        }
        
        stage('Test') {
            steps {
                bat "tests.cmd"
            }
        }
        
        stage('Archive') {
            steps {
                dir('C:\\Users\\Gigabyte\\Desktop\\Programs\\ConsoleApp\\CalcAdmin\\builds'){
                    zip zipFile: "${BUILD_NUMBER}.zip", archive:false, dir: 'C:\\Users\\Gigabyte\\.jenkins\\workspace\\Test2\\CalcAdmin\\bin\\Debug\\netcoreapp3.1'
                    archiveArtifacts artifacts: "${BUILD_NUMBER}.zip"
                }
            }
        }
        
        stage('Deploy') {
            steps {
                dir('C:\\Users\\Gigabyte\\Desktop\\Programs\\ConsoleApp\\CalcAdmin\\builds'){
                    bat("mkdir ..\\deploy\\${BUILD_NUMBER}")
                    unzip zipFile: "${BUILD_NUMBER}.zip", dir: "C:\\Users\\Gigabyte\\Desktop\\Programs\\ConsoleApp\\CalcAdmin\\deploy\\${BUILD_NUMBER}"
                }
            }
        }
    }
    
    post {
        always{
           emailext attachLog: true, body: '''$PROJECT_NAME - Build № $BUILD_NUMBER - $BUILD_STATUS:''',
                to: 'dondarubin@gmail.com'
        }
    }
}
