package com.example.finalproject

@Composable
fun AddNewItemScreen(navController: NavController, viewModel: BucketListViewModel) {
    var destinationName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var ranking by remember { mutableStateOf("") }
    val rankings = List(10) { (it + 1).toString() }  // Top 10 rankings

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF4F5F7))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = destinationName,
            onValueChange = { destinationName = it },
            label = { Text("Destination Name") }
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )
        DropdownMenu(
            rankings = rankings,
            selectedRank = ranking,
            onRankSelected = { ranking = it }
        )
        Button(onClick = {
            if (destinationName.isBlank() || description.isBlank() || ranking.isBlank()) {
                Toast.makeText(context, "All fields need to be populated", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.addDestination(destinationName, description, ranking.toInt())
                navController.popBackStack()
            }
        }) {
            Text("Add Destination")
        }
    }
}

@Composable
fun DropdownMenu(rankings: List<String>, selectedRank: String, onRankSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(selectedRank, modifier = Modifier.clickable { expanded = true })
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            rankings.forEach { rank ->
                DropdownMenuItem(onClick = {
                    onRankSelected(rank)
                    expanded = false
                }) {
                    Text(rank)
                }
            }
        }
    }
}
