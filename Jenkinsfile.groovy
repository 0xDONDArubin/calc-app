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
                dir('C:\Users\Gigabyte\Desktop\Programs\ConsoleApp\CalcAdmin\builds'){
                    echo "Current build: ${BUILD_NUMBER}"
                    zip zipFile: "${BUILD_NUMBER}.zip", archive:false, dir: 'C:\\Users\\Gigabyte\\.jenkins\\workspace\\Test2\\CalcAdmin\\bin\\Debug\\netcoreapp3.1'
                    archiveArtifacts artifacts: "${BUILD_NUMBER}.zip"
                }
            }
        }
    }
}
