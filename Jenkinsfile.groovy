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
                archiveArtifacts artifacts: 'CalcAdmin/bin/Debug/netcoreapp3.1/*', followSymlinks: false
            }
            steps {
                archiveArtifacts '${BUILD_NUMBER}.zip',
                                 artifacts: 'CalcAdminTests/bin/Debug/netcoreapp3.1/*', 
                                 followSymlinks: false, 
                                 onlyIfSuccessful: true,
            }
        }
    }
}
