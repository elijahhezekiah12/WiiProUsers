package com.elijahhezekiah.wiiprousers.presentation.job_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

//import com.elijahhezekiah.wiiprousers.presentation.job_details.components.MapScreen


@Composable
fun JobDetailsScreen (
    viewModel: JobDetailsViewModel = hiltViewModel(),
    id: Int
     
) {

   LaunchedEffect(key1 = true) {
       viewModel.getUserJobDetails(id)
   }

    val state = viewModel.state.value

    Scaffold { innerPadding ->

    state.jobDetails?.let { job ->
 
            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .padding(bottom = innerPadding.calculateBottomPadding()),
                horizontalAlignment = Alignment.Start
            ) {

           item {

               Column (
                   modifier = Modifier.padding(10.dp)
                       .padding(horizontal = 10.dp, vertical = 16.dp)
                       .fillMaxWidth(),
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {

                   Text(
                       text = job?.company?.name ?: "",
                       style = MaterialTheme.typography.displayMedium
                   )
                   Spacer(modifier = Modifier.height(10.dp))
                   Text(
                       text = job?.company?.catchPhrase ?: "",
                       style = MaterialTheme.typography.headlineSmall
                   )
                   Spacer(modifier = Modifier.height(10.dp))
                   Text(
                       text = job?.company?.bs ?: "",
                       style = MaterialTheme.typography.headlineSmall
                   )

               }
             }


/*

          item(job.website) {
              Column(
                  modifier = Modifier.padding(10.dp)
                      .padding(horizontal = 10.dp, vertical = 16.dp)
                      .fillMaxWidth(),
                  horizontalAlignment = Alignment.CenterHorizontally
              ) {
                  // Adding a WebView inside AndroidView
                  // with layout as full screen
                  AndroidView(factory = {
                      WebView(it).apply {
                          layoutParams = ViewGroup.LayoutParams(
                              ViewGroup.LayoutParams.MATCH_PARENT,
                              ViewGroup.LayoutParams.MATCH_PARENT
                          )
                      }
                  }, update = {
                      it.loadUrl(job.website)
                  })
              }

          }

*/

      item {

        Text(
              text = "${job?.address?.street}, ${job?.address?.suite}, ${job?.address?.city}, ${job?.address?.zipcode})",
              style = MaterialTheme.typography.bodySmall,
              overflow = TextOverflow.Ellipsis
          )

      /*   MapScreen(
               job.address
             )*/

          }
         }
       }


    }
}