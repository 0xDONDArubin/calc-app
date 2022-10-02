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
                archiveArtifacts artifacts: 'CalcAdmin/bin/Debug/netcoreapp3.1/*${BUILD_NUMBER}.zip', 
                                 followSymlinks: false
                archiveArtifacts artifacts: 'CalcAdminTests/bin/Debug/netcoreapp3.1/*${BUILD_NUMBER}.zip', 
                                 followSymlinks: false
            }
        }
    }
}
