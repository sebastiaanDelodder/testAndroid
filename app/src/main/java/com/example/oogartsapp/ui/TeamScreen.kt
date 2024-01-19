package com.example.oogartsapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oogartsapp.R
import com.example.oogartsapp.components.team.DetailComp
import com.example.oogartsapp.model.Employee
import com.example.oogartsapp.model.Group
import java.time.LocalDate


//data class Employee(val imageRes: Int, val firstName: String, val lastName: String, val function: String, val specializations: List<String>?)
val groups = listOf(
    Group("Oogartsen", 1),
    Group("Assistenten", 2),
    Group("Secretariaat", 3),
)
val employees = listOf(
    Employee("Olivia", "Van Dam", LocalDate.parse("1990-04-04"), groups[0], "Hier komt biografie",
        R.drawable.doctor1
    ),
    Employee("Pedro", "Van Dam", LocalDate.parse("2002-12-07"), groups[0], "Hier komt biografie",
        R.drawable.doctor6
    ),
    Employee("Emma","Johnson", LocalDate.parse("1995-12-12"), groups[0], "Hier komt biografie",
        R.drawable.doctor1
    ),
    Employee("Liam", "Rodriguez", LocalDate.parse("1990-04-04"), groups[1], "Hier komt biografie",
        R.drawable.doctor6
    ),
    Employee("Eva", "Thompson", LocalDate.parse("1990-04-04"), groups[1], "Hier komt biografie",
        R.drawable.doctor3
    ),
    Employee("Noah", "Van Broeckem", LocalDate.parse("1990-04-04"), groups[1], "Hier komt biografie",
        R.drawable.doctor4
    ),
    Employee("Sophie", "Martinez", LocalDate.parse("1990-04-04"), groups[2], "Hier komt biografie",
        R.drawable.doctor1
    ),
    Employee("Logan", "Willems", LocalDate.parse("1990-04-04"), groups[2], "Hier komt biografie",
        R.drawable.doctor6
    ),
    Employee("Lukas", "Brown", LocalDate.parse("1990-04-04"), groups[2], "Hier komt biografie",
        R.drawable.doctor5
    ),
    Employee("Julie", "Degrande", LocalDate.parse("1990-04-04"), groups[2], "Hier komt biografie",
        R.drawable.doctor3
    ),
)

@Preview(showBackground = true, widthDp = 800, heightDp = 600)
@Composable
fun GroupCardPreview() {
    //TeamMemberCard(employees[1], onClick = {})
    TeamMemberRow(employees = employees) {}
    //GroupCard(group = groups[0].name, teamMembers = employees, onClick = {}, modifier = Modifier)
    //HomeComp(innerPadding = PaddingValues(0.dp), onMemberClick = {})
}


@Composable
fun GroupCard(group: String, teamMembers : List<Employee>, onClick: (Employee) -> Unit, modifier: Modifier) {
    Column {
        Text(
            text = group,
            modifier = Modifier
                .padding(start = 16.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.padding(start = 16.dp))
        Divider(color = Color.LightGray, thickness = 1.dp)
        Spacer(modifier = Modifier.padding(end = 16.dp))
        TeamMemberRow(teamMembers, onMemberClick = onClick)
    }

}

@Composable
fun TeamMemberCard(employee: Employee, onClick: () -> Unit){
    val nameDisplay = employee.firstName + " " + employee.lastName

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .clickable(onClick = onClick)
        /*        .background(MaterialTheme.colorScheme.surfaceVariant)*/
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = employee.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = nameDisplay,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    lineHeight = 12.sp
                )
            )
        }
    }
}


@Composable
fun TeamMemberRow(employees: List<Employee>, onMemberClick: (Employee) -> Unit){
    LazyRow() {
        items(employees) { employee ->
            TeamMemberCard(
                employee = employee,
                onClick = { onMemberClick(employee) })
        } 
    }
}



@Composable
fun HomeComp(innerPadding: PaddingValues, onMemberClick: (Employee) -> Unit) {
    //TODO DB
    var gr = groups.sortedBy { it.sequence }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(innerPadding)
    ) {
        LazyColumn(
            modifier = Modifier
                //.fillMaxSize()
                .align(Alignment.TopStart)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            items(gr) { group ->
                GroupCard(
                    group = group.name,
                    teamMembers = employees.filter { it.group.name == group.name }, onClick = onMemberClick, modifier = Modifier)
            }
        }
    }
}






@Composable
fun TeamScreen(innerPadding: PaddingValues) {
    var selectedMember by remember { mutableStateOf<Employee?>(null) }

    if (selectedMember != null) {
        DetailComp(innerPadding = innerPadding, selectedMember!!, onBack = { selectedMember = null })
    } else {
        HomeComp(innerPadding = innerPadding) { teamMember ->
            selectedMember = teamMember
        }
    }
}

/*
@Composable
fun DetailComp(innerPadding: PaddingValues, teamMember: Employee, onBack: () -> Unit) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            IconButton(
                onClick = { onBack() },
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Row(
                modifier = Modifier
                    .padding(8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Image(
                        painter = painterResource(id = teamMember.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${teamMember.firstName} ${teamMember.lastName}",
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    )
                    Row(
                        modifier = Modifier
                            .padding(8.dp),
                    ) {
                        if (teamMember.specializations != null) {
                            LazyColumn {
                                items(teamMember.specializations) { specialization ->
                                    Text(
                                        text = specialization,
                                        textAlign = TextAlign.Center,
                                        fontWeight = FontWeight.SemiBold,
                                        fontStyle = FontStyle.Italic,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }

                        }
                        else {
                            Text(
                                text = teamMember.function,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold,
                                fontStyle = FontStyle.Italic,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(8.dp),
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}

*/