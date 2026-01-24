pipeline {
    agent any

    environment {
        SCANNER_HOME = tool 'sonar-scanner'
        NVD_API_KEY = credentials('nvd-api-key')  // Jenkins secret text credential
    }

    tools {
        maven 'maven3'
        jdk 'jdk-17'
    }

    stages {
        stage('git checkout') {
            steps {
                // UPDATED: Points to your new Bank repository
                git branch: 'main', url: 'https://github.com/rknikhade1419/Bank.git'
            }
        }

        stage('compile') {
            steps {
                sh "mvn clean compile"
            }
        }

        stage('unit tests') {
            steps {
                sh "mvn test -DskipTests=true"
            }
        }

        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonar-scanner') {
                    sh "${env.SCANNER_HOME}/bin/sonar-scanner \
                        -Dsonar.projectKey=BANK-SYSTEM \
                        -Dsonar.projectName=BANK-SYSTEM \
                        -Dsonar.java.binaries=target/classes"
                }
            }
        }

        stage('OWASP Dependency Check') {
            steps {
                  withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
                    dependencyCheck additionalArguments: "--nvdApiKey=$NVD_API_KEY",
                                    odcInstallation: 'DC'
             }
        }
        }

        stage('Build') {
            steps {
                sh "mvn package -DskipTests=true"
            }
        }

        stage('deploy to Nexus') {
            steps {
                withMaven(globalMavenSettingsConfig: 'global-maven', jdk: 'jdk-17', maven: 'maven3', mavenSettingsConfig: '', traceability: true) {
                    sh "mvn deploy -DskipTests=true"
                }
            }
        }
        

        stage('build and Tag docker image') {
            steps {
                script {
                        // UPDATED: Image name changed to banking-system
                        sh "docker build -t youngminds73/banking-system:latest -f docker/Dockerfile ."
                    }
            }
        }

        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u youngminds73 -p ${dockerhubpwd}'}
                   // UPDATED: Pushing the banking-system image
                   sh 'docker push youngminds73/banking-system:latest'
                }
            }
        }

        stage('EKS and Kubectl configuration'){
            steps{
                script{
                    sh 'aws eks update-kubeconfig --region ap-south-1 --name project-cluster'
                }
            }
        }

        stage('Deploy to k8s'){
            steps{
                script{
                    // This uses the deploymentservice.yml we updated earlier
                    sh 'kubectl apply -f deploymentservice.yml'
                }
            }
        }
    }
}
