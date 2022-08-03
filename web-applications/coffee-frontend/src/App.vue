<script setup>
import { onMounted, ref } from 'vue';

const coffeeList = ref([]);

onMounted(() => {
  fetch('http://localhost:8080/api/coffee')
    .then(res => res.json())
    .then(data => {
      coffeeList.value = data;
    });
})
</script>

<template>
  <div class="container mx-auto">
    <h1 class="text-3xl font-bold py-4">Coffee Orders</h1>
    <p>This is a collection of Coffee orders placed today.</p>

    <div class="flex flex-col">
      <div class="overflow-x-auto sm:-mx-6 lg:-mx-8">
        <div class="py-2 inline-block min-w-full sm:px-6 lg:px-8">
          <div class="overflow-hidden">
            <table class="min-w-full">
              <thead class="bg-white border-b">
                <tr>
                  <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                    #
                  </th>
                  <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                    Name
                  </th>
                  <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                    Size
                  </th>
                  <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                    Price
                  </th>
                  <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                    Cost
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(coffee, index) in coffeeList" :key="coffee.id"
                  :class="index % 2 === 0 ? 'bg-gray-100' : 'bg-white'" class="border-b">
                  <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{{ coffee.id }}</td>
                  <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {{ coffee.name }}
                  </td>
                  <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {{ coffee.size }}
                  </td>
                  <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {{ coffee.price }}
                  </td>
                  <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {{ coffee.cost }}
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
