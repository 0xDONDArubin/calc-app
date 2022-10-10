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
                echo "Current build: ${BUILD_NUMBER}"
                zip zipFile: "${BUILD_NUMBER}.zip", archive:false, dir: 'C:\\Users\\Gigabyte\\.jenkins\\workspace\\Test2\\CalcAdmin\\bin\\Debug\\netcoreapp3.1'
                archiveArtifacts artifacts: "${BUILD_NUMBER}.zip"
//                 archiveArtifacts artifacts: "${BUILD_NUMBER}.zip"
              
//                 archiveArtifacts artifacts: 'CalcAdmin/bin/Debug/netcoreapp3.1/*', 
//                                  followSymlinks: false
//                 archiveArtifacts artifacts: 'CalcAdminTests/bin/Debug/netcoreapp3.1/*', 
//                                  followSymlinks: false
//                 echo "${BUILD_ID}"
            }
        }
    }
}
