pipeline {
    agent any

    stages {
        stage('Source Code Update') {
            steps {
                git branch: 'main', credentialsId: 'po', url: 'git@github.com:pavelo8501/JTest.git'
                echo 'Hello World'
            }
        }
    }
}
