node {
   def mvnHome


   stage('Preparation') { // for display purposes

        println "start"
        git 'https://github.com/nikrosss/pipline.git'
        bat (/groovy build_conf_fp_name.groovy %FP_NAME%/)
   }
   stage('Build') {


   }
   stage('Results') {

   }
}
