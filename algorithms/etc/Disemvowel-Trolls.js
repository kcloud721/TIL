function disemvowel(str) {
    const vowels = /[aeiou]+/gi;
    str = str.replace(vowels, "");
    return str;
  }