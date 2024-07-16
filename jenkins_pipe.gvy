pipeline {
    agent any
    environment {
        NPM_CONFIG_CACHE = "${WORKSPACE}/.npm"
    }
    stages {
        stage('Source Code Update') {
            steps {
                echo '-----------------Downloading Source Code-------------------------'
                git branch: 'main', credentialsId: 'po', url: 'git@github.com:pavelo8501/OVP.git'
                echo '-----------------Download Complete--------------------------------'                
            }
        }
        stage('Angular Compilation'){
            steps{
                echo '-----------------Compilling Angular------------------------------'
                dir('admin') {
                    sh 'npm install'
                    sh 'npm run ng build --base-href /ovpadmin/ --deploy-url /ovpadmin/ --output-hashing none'
                }
                echo '-----------------Angular Compilation End-------------------------'
            }
        }
    }
}
