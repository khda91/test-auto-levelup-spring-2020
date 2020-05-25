pipeline {
   agent any

 tools {
    maven 'MAVEN-3.6.3_1'
  }

   stages {

      stage('Checkout') {
        // Get some code from a GitHub repository
        steps {
        git 'https://github.com/khda91/test-auto-levelup-spring-2020.git'
        }
      }

      stage('Execute QA Acceptance') {
         steps {
            // Run Maven on a Unix agent.
            sh "mvn clean verify"
         }
      }

        stage ('Set build description') {
        steps{
            buildDescription 'branch: ${BRANCH_NAME}'
            }
        }

      stage('Generate report') {
      steps {
        allure includeProperties: false, jdk: '', results: [[path: 'allure-results'], [path: 'target/allure-results']]
        }
      }
   }
}
