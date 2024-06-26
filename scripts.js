// Contact Management System
function addContact() {
    const name = document.getElementById('contactName').value;
    const email = document.getElementById('contactEmail').value;
    const phone = document.getElementById('contactPhone').value;

    fetch('/api/contacts', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, email, phone })
    }).then(response => {
        if (response.ok) {
            alert('Contact added!');
            loadContacts();
        }
    });
}

function loadContacts() {
    fetch('/api/contacts')
        .then(response => response.json())
        .then(contacts => {
            const contactList = document.getElementById('contactList');
            contactList.innerHTML = '';
            contacts.forEach(contact => {
                const li = document.createElement('li');
                li.textContent = `${contact.name} - ${contact.email} - ${contact.phone}`;
                contactList.appendChild(li);
            });
        });
}

// Sorting Algorithm Visualizer
function sortArray(type) {
    const input = document.getElementById('sortInput').value;
    const array = input.split(',').map(Number);

    fetch(`/api/sort/${type}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(array)
    }).then(response => response.json())
        .then(sortedArray => {
            document.getElementById('sortOutput').textContent = `Sorted Array: ${sortedArray.join(', ')}`;
        });
}

// Pathfinding Algorithm Visualizer
function runPathfinding(algorithm) {
    // Placeholder: Define your grid, start, and end points here
    const grid = [[0, 0, 1], [0, 0, 0], [1, 0, 0]];
    const start = [0, 0];
    const end = [2, 2];

    fetch(`/api/pathfinding/${algorithm}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ grid, start, end })
    }).then(response => response.json())
        .then(path => {
            document.getElementById('pathOutput').textContent = `Path: ${JSON.stringify(path)}`;
        });
}

// Binary Search Tree Visualizer
function bstInsert() {
    const value = parseInt(document.getElementById('bstValue').value);
    fetch(`/api/bst/insert?key=${value}`, { method: 'POST' })
        .then(() => loadTree());
}

function bstDelete() {
    const value = parseInt(document.getElementById('bstValue').value);
    fetch(`/api/bst/delete?key=${value}`, { method: 'DELETE' })
        .then(() => loadTree());
}

function loadTree() {
    fetch('/api/bst/structure')
        .then(response => response.json())
        .then(nodes => {
            drawTree(nodes);
        });
}

function drawTree(nodes) {
    const svg = d3.select("#bstCanvas");
    svg.selectAll("*").remove(); // Clear previous content

    const treeData = buildTreeData(nodes);
    const root = d3.hierarchy(treeData);
    const treeLayout = d3.tree().size([400, 400]);
    const link = svg.append("g").selectAll(".link")
        .data(treeLayout(root).links())
        .enter().append("line")
        .attr("class", "link")
        .attr("x1", d => d.source.x)
        .attr("y1", d => d.source.y)
        .attr("x2", d => d.target.x)
        .attr("y2", d => d.target.y)
        .attr("stroke", "#ccc");

    const node = svg.append("g").selectAll(".node")
        .data(root.descendants())
        .enter().append("g")
        .attr("class", "node")
        .attr("transform", d => `translate(${d.x},${d.y})`);

    node.append("circle")
        .attr("r", 5)
        .attr("fill", "#007bff");

    node.append("text")
        .attr("dy", -10)
        .attr("text-anchor", "middle")
        .text(d => d.data.name);
}

function buildTreeData(nodes) {
    const nodeMap = {};
    nodes.forEach(node => nodeMap[node.key] = { name: node.key, children: [] });
    nodes.forEach(node => {
        if (node.parent !== null) {
            nodeMap[node.parent].children.push(nodeMap[node.key]);
        }
    });
    return nodeMap[nodes[0].key];
}
