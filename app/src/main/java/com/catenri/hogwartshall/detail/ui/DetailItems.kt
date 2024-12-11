package com.catenri.hogwartshall.detail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.catenri.hogwartshall.common.ui.InfoBadge
import com.catenri.hogwartshall.ui.theme.HogwartsHallTheme

@Composable
fun DescriptionItem(
    label: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DescriptionItemPreview() {
    HogwartsHallTheme {
        DescriptionItem(
            label = "Label",
            value = "Label",
            icon = Icons.Outlined.Person
        )
    }
}

@Composable
fun LifeStatusBadge(isAlive: Boolean) {
    val text = if (isAlive) "Alive" else "Deceased"

    val textColor = if (isAlive)
        MaterialTheme.colorScheme.onPrimaryContainer
    else
        MaterialTheme.colorScheme.onErrorContainer

    val backgroundColor = if (isAlive)
        MaterialTheme.colorScheme.primaryContainer
    else
        MaterialTheme.colorScheme.errorContainer

    val detailColor = if (isAlive)
        MaterialTheme.colorScheme.primary
    else
        MaterialTheme.colorScheme.error

    InfoBadge(
        text = text,
        textColor = textColor,
        backgroundColor = backgroundColor,
        detailColor = detailColor
    )
}

@Preview(name = "Badge when character is alive")
@Composable
private fun LifeStatusBadgeAlivePreview() {
    HogwartsHallTheme {
        LifeStatusBadge(
            isAlive = true
        )
    }
}

@Preview(name = "Badge when character is deceased")
@Composable
private fun LifeStatusBadgeDeceasedPreview() {
    HogwartsHallTheme {
        LifeStatusBadge(
            isAlive = false
        )
    }
}