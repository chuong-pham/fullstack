/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
    let result = [];
    let hashmap = new Map();

    for(let str of strs) {
        for(let ch of str) {
            hashmap.set(ch, 1);
        }
    }

    console.log(hashmap);
};

const strs = ["eat", "tea", "tan", "ate", "nat", "bat"];
groupAnagrams(strs);