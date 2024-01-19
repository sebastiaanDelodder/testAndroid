package com.example.oogartsapp.components.team

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oogartsapp.R
import com.example.oogartsapp.model.Employee
import com.example.oogartsapp.model.Group
import java.time.LocalDate


@Preview(showBackground = true)
@Composable
fun DetailCompPreview() {
    DetailComp(
        innerPadding = PaddingValues(0.dp),
        employee = Employee(
            "John",
            "Doe",
            LocalDate.parse("1990-01-01"),
            Group("Oogartsen", 1),
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            R.drawable.doctor1
        ),
        onBack = {})
}
@Composable
fun DetailComp(innerPadding: PaddingValues, employee: Employee, onBack: () -> Unit) {
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
                        painter = painterResource(id = employee.imageRes),
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
                        text = "${employee.firstName} ${employee.lastName}",
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
                        /*
                        if (employee.specializations != null) {
                            LazyColumn {
                                items(employee.specializations) { specialization ->
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
                                text = employee.function,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold,
                                fontStyle = FontStyle.Italic,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }*/
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(8.dp),
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = employee.bio,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}