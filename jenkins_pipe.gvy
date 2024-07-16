pipeline {
    agent any

    stages {
        stage('Source Code Update') {
            steps{
                echo '-----------------Downloading Source Code-------------------------'
            }
            steps {
                git branch: 'main', credentialsId: 'po', url: 'git@github.com:pavelo8501/OVP.git'
            }
            steps{
                echo '-----------------Downloading Complete-----------------------------'
            }
        }
    }
}
